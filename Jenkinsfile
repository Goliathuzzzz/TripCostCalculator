pipeline {
    agent any
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
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }
    }
}
