pipeline{
    agent any
     tools {
        maven "Maven_Home"
    }
    stages
    {
        stage('checkout'){
       steps{
           git branch:'master',url: 'https://github.com/Mysticgamer18/CaseStudy_Hybrid.git'
        }
        }
        stage('Build')
        {
            steps
            {
                bat 'mvn clean compile'
            }
        }
        stage('Test')
        {
            steps
            {
                bat 'mvn test'
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }
      
}