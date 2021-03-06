# SpringBoot-Kafka


    
### Commands

- #### Create new Kafka topic

        bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

- #### List all the topics

        bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
    
### Properties

    retention time (เวลาในการเก็บรักษา message)

### Reference

- https://www.cloudkarafka.com/blog/2016-11-30-part1-kafka-for-beginners-what-is-apache-kafka.html
- https://www.tutorialspoint.com/apache_kafka/apache_kafka_consumer_group_example.htm
- https://martinfowler.com/articles/201701-event-driven.html
- https://reflectoring.io/spring-boot-kafka/
- https://medium.com/@_amanarora/replication-in-kafka-58b39e91b64e
- https://codingnconcepts.com/spring-boot/configure-kafka-producer-and-consumer/ (Kafka SSL)
- https://medium.com/@TimvanBaarsen/programmatically-create-kafka-topics-using-spring-kafka-8db5925ed2b1
- https://docs-snaplogic.atlassian.net/wiki/spaces/SD/pages/1438858/Configuring+Confluent+Kafka+Accounts
