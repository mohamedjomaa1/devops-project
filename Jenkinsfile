pipeline {
    agent any

    tools {
        jdk 'JDK_11'
        maven 'Maven 3.9.9'
        nodejs 'NodeJS'  // Make sure this is Node v18 or v20
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
                git branch: 'master', url: 'https://github.com/mohamedjomaa1/devops-project.git'
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
}
*/