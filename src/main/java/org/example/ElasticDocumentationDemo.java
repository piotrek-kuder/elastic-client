package org.example;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.TransportUtils;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import javax.net.ssl.SSLContext;

public class ElasticDocumentationDemo {
    private static final String FINGERPRINT = "08:98:BE:F9:40:A5:C0:E6:60:33:8C:DE:ED:7C:4B:57:BD:1E:64:F1:0E:81:E8:BC:B4:B8:8E:32:D8:FF:F5:31";
    private static final String LOGIN = "elastic";
    private static final String PASSWORD = "mHFRPVoeyo6Il0QM7zSy";
    private static final String HOST = "elastic:mHFRPVoeyo6Il0QM7zSy";
    private static final Integer PORT = 9200;
    private static final Logger LOG = LoggerFactory.getLogger(ElasticDocumentationDemo.class);

    public static void main(String[] args) throws IOException {
        LOG.info("Hello Elastic!");

        ElasticsearchClient esClient = createEsClient();
        esClient._transport().close();

    }

    private static ElasticsearchClient createEsClient() {
        SSLContext sslContext = TransportUtils
                .sslContextFromCaFingerprint(FINGERPRINT);

        BasicCredentialsProvider credsProv = new BasicCredentialsProvider();
        credsProv.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(LOGIN, PASSWORD));

        RestClient restClient = RestClient
                .builder(new HttpHost(HOST, PORT, "https"))
                .setHttpClientConfigCallback(hc -> hc
                        .setSSLContext(sslContext)
                        .setDefaultCredentialsProvider(credsProv)
                )
                .build();

        // Create the transport and the API client
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        return new ElasticsearchClient(transport);
    }
}
