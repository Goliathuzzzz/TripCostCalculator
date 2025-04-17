pipeline {
    agent any
    environment {
            // Define Docker Hub credentials ID
            DOCKERHUB_CREDENTIALS_ID = '338f98cb-c0d0-4baa-ae27-7ab4389daed3'
            // Define Docker Hub repository name
            DOCKERHUB_REPO = 'mikaklaa/test_repo'
            // Define Docker image tag
            DOCKER_IMAGE_TAG = 'latest_v1'

            SONARQUBE_SERVER = 'SonarQube Server' // The name of the SonarQube server configured in Jenkins

            SONAR_TOKEN = 'squ_1fda77ada553ff5feda58708b9dac8dda4b5fba9'

        }
    tools {
        maven 'maven_3.9.9'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: "main", url:'https://github.com/Goliathuzzzz/TripCostCalculator'
            }
        }
        stage('Build & Test') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('SonarQube Analysis') {
             steps {
                script {
                     def scannerHome = tool 'SonarQube Scanner'
                     withSonarQubeEnv(SONARQUBE_SERVER) {
                         bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=devops-demo -Dsonar.sources=src -Dsonar.projectName=TripCostCalculator -Dsonar.host.url=http://localhost:9000 -Dsonar.token=${SONAR_TOKEN} -Dsonar.java.binaries=target/classes"
                     }
                 }
             }
         }
        stage('Build Docker Image') {
            steps {
                // Build Docker image
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                // Push Docker image to Docker Hub
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}
