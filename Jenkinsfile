pipeline {
    agent any

    tools {
        jdk 'JDK_11'
        maven 'Maven 3.9.9'
        nodejs 'NodeJS'  // Make sure this is Node v18 or v20
    }

    environment {
	
        PATH = "C:\\Program Files\\Git\\bin;${env.PATH};C:\\Program Files\\Docker\\Docker\\resources\\bin"
        FRONTEND_IMAGE = 'mohamedjomaa1/devops-frontend'
        BACKEND_IMAGE = 'mohamedjomaa1/devops-backend'
        VERSION = '1.2'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Cloning the repository..."
                git branch: 'master', url: 'https://github.com/mohamedjomaa1/devops-project.git'
            }
        }

        stage('Build Frontend') {
            steps {
                echo "Building Frontend..."
                script {
                    def frontendDir = "${WORKSPACE}/frontend"
                    if (isUnix()) {
                        sh """
                            cd ${frontendDir}
                            npm install --omit=dev
                            npm audit fix || true
                            npm run build --prod
                        """
                    } else {
                        bat """
                            cd ${frontendDir}
                            npm install --omit=dev
                            npm audit fix || exit /b 0
                            npm run build --prod
                        """
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

         stage('Unit Tests') {
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






        /*stage('Deploy') {
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
        }*/

        stage('Deploy') {
    steps {
        script {
            echo "Listing files in workspace:"
            bat 'dir'  // For Windows systems
            bat 'docker-compose -f docker-compose.yml down --remove-orphans'
            bat 'docker-compose -f docker-compose.yml up -d'
        }
    }
}




    }
}
