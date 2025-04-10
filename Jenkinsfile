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
				git branch: 'master', url: 'https://github.com/mohamedjomaa1/devops-project.git'
            }
        }



        stage('Build Frontend') {
			steps {
				script {
					def frontendDir = "${WORKSPACE}/frontend"
                    if (isUnix()) {
						sh "cd ${frontendDir} && npm install && npm run build --prod"
                    } else {
						bat "cd ${frontendDir} && npm install && npm run build --prod"
                    }
                }
            }
        }

        stage('Build Backend') {
			steps {
				script {
                    def backendDir = "${WORKSPACE}/backend"
                    if (isUnix()) {
						sh "cd ${backendDir} && mvn clean install package"
                    } else {
						bat "cd ${backendDir} && mvn clean install package"
                    }
                }
            }
        }

        stage('Tests Unitaires') {
			steps {
				script {
                    def backendDir = "${WORKSPACE}/backend"
                    if (isUnix()) {
						sh "cd ${backendDir} && mvn test"
                    } else {
						bat "cd ${backendDir} && mvn test"
                    }
                }
            }
            post {
				always {
                    archiveArtifacts artifacts: 'backend/target/surefire-reports/*.xml', allowEmptyArchive: true
                }
            }
        }

        stage('Build Docker Images') {
			steps {
				script {
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
                }
            }
        }

        stage('Deploy') {
			steps {
				script {
                    if (isUnix()) {
						sh 'docker-compose -f docker-compose.yml down --remove-orphans'
                        sh 'docker-compose -f docker-compose.yml up -d'
                    } else {
						bat 'docker-compose -f docker-compose.yml down --remove-orphans'
                        bat 'docker-compose -f docker-compose.yml up -d'
                    }
                }
            }
        }
    }
}



/*pipeline {
    agent any

    tools {
        jdk 'JDK_11'
        maven 'Maven 3.9.9'
        nodejs 'NodeJS'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Cloning the repository..."
                git branch: 'master', url: 'https://github.com/mohamedjomaa1/project-devops.git'
            }
        }

        stage('Build Frontend') {
            steps {
                echo "Building Frontend..."
                script {
                    def frontendDir = "${WORKSPACE}/frontend"
                    if (isUnix()) {
                        sh "cd ${frontendDir} && npm install && npm run build --prod"
                    } else {
                        bat "cd ${frontendDir} && npm install && npm run build --prod"
                    }
                }
            }
        }

        stage('Build Backend') {
            steps {
                echo "Building Backend..."
                script {
                    def backendDir = "${WORKSPACE}/backend"
                    if (isUnix()) {
                        sh "cd ${backendDir} && mvn clean install"
                    } else {
                        bat "cd ${backendDir} && mvn clean install"
                    }
                }
            }
        }
    }
}*
