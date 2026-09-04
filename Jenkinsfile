pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

    }

    post {
        success {
            echo 'Build exitoso: MyConstruction.war generado correctamente.'
        }

        failure {
            echo 'El build de MyConstruction fallo.'
        }
    }
}