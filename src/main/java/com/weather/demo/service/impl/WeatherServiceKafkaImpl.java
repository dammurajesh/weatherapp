package com.weather.demo.service.impl;


import com.weather.demo.model.Weather;
import com.weather.demo.service.WeatherService;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.ForeachAction;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

@Service
public class WeatherServiceKafkaImpl implements WeatherService {

    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, WeatherAvro> kafkaTemplate;

    public WeatherServiceKafkaImpl() {
        final Properties props = new Properties();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "weather-info");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        props.setProperty("bootstrap.servers", "broker:9092");
        props.setProperty("acks", "all");
        props.setProperty("retries", "10");
// Avro properties
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        props.setProperty("schema.registry.url", "http://localhost:8081");

//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    }
    KafkaProducer<String, WeatherAvro> kafkaProducer;

    @Override
    public void saveWeatherInformation(Weather weather) {

        WeatherAvro avrotest = WeatherAvro.newBuilder()
                .setLocationId("123")
                .setLat(weather.getLat())
                .setLng(weather.getLng())
                .setTemperature(weather.getTemperature())
                .build();


        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        KafkaProducer<String, WeatherAvro> kafkaProducer = new KafkaProducer<String, WeatherAvro>(props);
        ProducerRecord<String, WeatherAvro> producerRecord = new ProducerRecord<String, WeatherAvro>("weather-1", avrotest);

        kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if(exception == null)
                    System.out.println("success");
                else
                    exception.printStackTrace();
            }
        });
        kafkaProducer.flush();
        kafkaProducer.close();
    }


    @Override
    public String getWeather() {
        return null;
    }

}
