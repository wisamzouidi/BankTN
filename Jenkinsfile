pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        TOMCAT_PATH = "/opt/tomcat/latest" 
        WAR_FILE = "target/banktn-1.0-SNAPSHOT.war" 
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
                sh 'mvn clean package'
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

stage('Deploy to Tomcat') {
    steps {
        echo 'Déploiement de l\'application sur Tomcat.'
        
      
        sh "cp ${WAR_FILE} \$TOMCAT_PATH/webapps/"

      
        sh """
sudo ${TOMCAT_PATH}/bin/shutdown.sh || true
sudo ${TOMCAT_PATH}/bin/startup.sh
        """
    }
}
    }

    post {
        success {
            echo 'Pipeline exécuté avec succès'
        }
        failure {
            echo 'La pipeline a échoué'
        }
    }
}
