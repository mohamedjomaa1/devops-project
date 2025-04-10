pipeline {
    agent any

    tools {
        jdk 'JDK_11'
        maven 'Maven 3.9.9'
        nodejs 'NodeJS'
    }

    environment {
        PATH = "C:\\Program Files\\Git\\bin;${env.PATH};C:\\Program Files\\Docker\\Docker\\resources\\bin"
        FRONTEND_IMAGE = 'mohamedjomaa1/devops-frontend'
        BACKEND_IMAGE = 'mohamedjomaa1/devops-backend'
        VERSION = '1.0'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/mohamedjomaa1/project-devops.git'
            }
        }

        stage('Build Frontend') {
            steps {
                script {
                    def frontendDir = "${WORKSPACE}/frontend"
                    try {
                        if (isUnix()) {
                            sh "cd ${frontendDir} && npm install && npm run build --prod"
                        } else {
                            bat "cd ${frontendDir} && npm install && npm run build --prod"
                        }
                    } catch (Exception e) {
                        echo "Erreur lors de la construction du frontend : ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }

        stage('Build Backend') {
            steps {
                script {
                    def backendDir = "${WORKSPACE}/backend"
                    try {
                        if (isUnix()) {
                            sh "cd ${backendDir} && mvn clean install package"
                        } else {
                            bat "cd ${backendDir} && mvn clean install package"
                        }
                    } catch (Exception e) {
                        echo "Erreur lors de la construction du backend : ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    try {
                        if (isUnix()) {
                            sh """
                                docker build -t ${env.BACKEND_IMAGE}:${env.VERSION} ./backend
                                docker build -t ${env.FRONTEND_IMAGE}:${env.VERSION} ./frontend
                            """
                        } else {
                            bat """
                                docker build -t %BACKEND_IMAGE%:%VERSION% ./backend
                                docker build -t %FRONTEND_IMAGE%:%VERSION% ./frontend
                            """
                        }
                    } catch (Exception e) {
                        echo "Erreur lors de la construction des images Docker : ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    try {
                        if (isUnix()) {
                            sh 'docker-compose -f docker-compose.yml down --remove-orphans'
                            sh 'docker-compose -f docker-compose.yml up -d'
                        } else {
                            bat 'docker-compose -f docker-compose.yml down --remove-orphans'
                            bat 'docker-compose -f docker-compose.yml up -d'
                        }
                    } catch (Exception e) {
                        echo "Erreur lors du déploiement Docker : ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }
    }
}
