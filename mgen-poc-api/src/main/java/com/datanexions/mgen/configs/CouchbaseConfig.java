package com.datanexions.mgen.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    @Value("${couchbase.bootstrap-servers}")
    private String host;
    @Value("${couchbase.bucketName}")
    private String bucketName;

    @Value("${couchbase.bucketNameLoopback}")
    private String bucketNameLoopback;
    @Value("${couchbase.userName}")
    private String userName;
    @Value("${couchbase.password}")
    private String password;

    @Override
    public String getConnectionString() {
        return "couchbase://" + host;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }
}
