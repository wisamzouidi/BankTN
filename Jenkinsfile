pipeline {
    agent any


   tools {
        maven 'Maven3'
    }


    stages {
        stage('Checkout') {
            steps {
                echo 'Récupération du code depuis GitHub'
                git 'https://github.com/wisamzouidi/BankTN.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Compilation et packaging du projet...'
                sh 'mvn clean install package'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Exécution des tests unitaires.'
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('SAST - SonarQube Analysis') {
            steps {
                echo 'Analyse de sécurité et qualité avec SonarQube.'
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo 'Déploiement de l\'application sur Tomcat.'
                sh "cp target/*.war ${TOMCAT_PATH}"
            }
        }
    }

    post {
        success {
            echo 'Pipeline exécuté avec succès !'
        }
        failure {
            echo 'La pipeline a échoué !'
        }
    }
}
