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

        stage('Deploy to Artifactory') {

            steps {

                withCredentials([
                    usernamePassword(
                        credentialsId: 'artifactory-creds',
                        usernameVariable: 'ART_USER',
                        passwordVariable: 'ART_PASS'
                    )
                ]) {

                    bat 'curl.exe -u "%ART_USER%:%ART_PASS%" -T target\\MyConstruction-app.jar http://localhost:8091/artifactory/myconstruction-releases/MyConstruction-app.jar'

                }

            }

        }

    }

    post {

        success {

            echo 'Build y despliegue exitosos: JAR publicado en JFrog Artifactory.'

        }

        failure {

            echo 'El build o despliegue de MyConstruction fallo.'

        }

    }

}