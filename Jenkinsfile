pipeline {
    environment {
        PATH = 'C:\\Program Files\\Git\\usr\\bin;C:\\Program Files\\Git\\bin;${env.Path}'
    agent = 'any'
    tool name: 'mvn'
    stages = {

         stage ('Test') {
                    steps {
                        print 'Running tests'
                        sh('mvn clean test')
                    }
                }

        stage ('Build') {
            steps {
                print 'Build'
                sh 'mvn clean package'
            }
        }
    }
    }
}