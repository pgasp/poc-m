package com.datanexions.mgen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;

@Configuration
@PropertySource("classpath:/application.yml")
public class Config {
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

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean("apiCollection")
	public Collection apiCollection() {
		Cluster cluster = Cluster.connect(host, userName, password);
		Bucket bucketObj = cluster.bucket(bucketName);
		Collection collection = bucketObj.defaultCollection();
		return collection;
	}

	@Bean("apiCluster")
	public Cluster apiCluster() {
		return Cluster.connect(host, userName, password);
	}

	@Bean("loopbackCollection")
	public Collection loopbackCollection() {
		Cluster clusterLoopback = Cluster.connect(host, userName, password);
		Bucket bucketObjLoopback = clusterLoopback.bucket(bucketNameLoopback);
		Collection collection = bucketObjLoopback.defaultCollection();
		return collection;
	}

	@Bean("loopbackCluster")
	public Cluster loopbackCluster() {
		return Cluster.connect(host, userName, password);
	}
}