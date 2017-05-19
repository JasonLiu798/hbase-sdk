package com.jason798.hbase.api;

import com.jason798.character.StringCheckUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

import java.io.Serializable;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class HbaseConfig implements Serializable {
    private static final long serialVersionUID = 9127057262491270703L;
    private String zookeeper;
    private int clientPort;
    private String master;
    private String pause = "50";// default 100
    private String retryCount = "10";//default 31

    /**
     * The default timeout is three minutes (specified in milliseconds). This means that if a server crashes, it will be three minutes before the Master notices the crash and starts recovery. You might like to tune the timeout down to a minute or even less so the Master notices failures the sooner. Before changing this value, be sure you have your JVM garbage collection configuration under control otherwise, a long garbage collection that lasts beyond the ZooKeeper session timeout will take out your RegionServer (You might be fine with this — you probably want recovery to start on the server if a RegionServer has been in GC for a long period of time).

     To change this configuration, edit hbase-site.xml, copy the changed file around the cluster and restart.

     We set this value high to save our having to field questions up on the mailing lists asking why a RegionServer went down during a massive import. The usual cause is that their JVM is untuned and they are running into long GC pauses. Our thinking is that while users are getting familiar with HBase, we’d save them having to know all of its intricacies. Later when they’ve built some confidence, then they can play with configuration such as this.
     */
    //zookeeper.session.timeout //default three minutes 3*60*1000


    /**
     * hbase.client.write.buffer
     Description
     Default size of the HTable client write buffer in bytes. A bigger buffer takes more memory — on both the client and server side since server instantiates the passed write buffer to process it — but a larger buffer size reduces the number of RPCs made. For an estimate of server-side memory-used, evaluate hbase.client.write.buffer * hbase.regionserver.handler.count
     Default 2097152
     */

    /**
     * hbase.client.max.total.tasks
     Description
     The maximum number of concurrent mutation tasks a single HTable instance will send to the cluster.
     Default 100
     */

    /**
     * hbase.client.max.perserver.tasks
     Description
     The maximum number of concurrent mutation tasks a single HTable instance will send to a single region server.

     Default
     5

     hbase.client.max.perregion.tasks
     Description
     The maximum number of concurrent mutation tasks the client will maintain to a single Region. That is, if there is already hbase.client.max.perregion.tasks writes in progress for this region, new puts won’t be sent to this region until some writes finishes.

     Default
     1

     hbase.client.perserver.requests.threshold
     Description
     The max number of concurrent pending requests for one server in all client threads (process level). Exceeding requests will be thrown ServerTooBusyException immediately to prevent user’s threads being occupied and blocked by only one slow region server. If you use a fix number of threads to access HBase in a synchronous way, set this to a suitable value which is related to the number of threads will help you. See https://issues.apache.org/jira/browse/HBASE-16388 for details.

     Default
     2147483647

     hbase.client.scanner.caching
     Description
     Number of rows that we try to fetch when calling next on a scanner if it is not served from (local, client) memory. This configuration works together with hbase.client.scanner.max.result.size to try and use the network efficiently. The default value is Integer.MAX_VALUE by default so that the network will fill the chunk size defined by hbase.client.scanner.max.result.size rather than be limited by a particular number of rows since the size of rows varies table to table. If you know ahead of time that you will not require more than a certain number of rows from a scan, this configuration should be set to that row limit via Scan#setCaching. Higher caching values will enable faster scanners but will eat up more memory and some calls of next may take longer and longer times when the cache is empty. Do not set this value such that the time between invocations is greater than the scanner timeout; i.e. hbase.client.scanner.timeout.period
     Default 2147483647=Integer.MAX_VALUE

     hbase.client.keyvalue.maxsize
     Description
     Specifies the combined maximum allowed size of a KeyValue instance. This is to set an upper boundary for a single entry saved in a storage file. Since they cannot be split it helps avoiding that a region cannot be split any further because the data is too large. It seems wise to set this to a fraction of the maximum region size. Setting it to zero or less disables the check.
     Default
     10485760 = 10*1024*1024

     ##超时相关
     hbase.client.scanner.timeout.period
     Description
     Client scanner lease period in milliseconds.
     Default 60*1000

     hbase.client.localityCheck.threadPoolSize
     Default 2

     ##超时相关
     hbase.client.operation.timeout
     Description
     Operation timeout is a top-level restriction (millisecond) that makes sure a blocking operation in Table will not be blocked more than this. In each operation, if rpc request fails because of timeout or other reason, it will retry until success or throw RetriesExhaustedException. But if the total time being blocking reach the operation timeout before retries exhausted, it will break early and throw SocketTimeoutException.
     Default 1200*1000

     ##type 性能/网络相关
     hbase.client.scanner.max.result.size
     Description
     Maximum number of bytes returned when calling a scanner’s next method. Note that when a single row is larger than this limit the row is still returned completely. The default value is 2MB, which is good for 1ge networks. With faster and/or high latency networks this value should be increased.
     Default 2097152
     */



    /**
     * must declare,for reflect
     */
    public HbaseConfig() {
    }

    public Configuration create() {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", this.zookeeper);
        conf.set("hbase.zookeeper.property.clientPort", "" + this.clientPort);
        //hbase.client.connection.impl
        //hbase.client.write.buffer
        if (StringCheckUtil.isNotEmpty(this.master)) {
            conf.set("hbase.master", this.master);
        }
        conf.set("hbase.client.pause", this.pause);
        conf.set("hbase.client.retries.number", this.retryCount);
        return conf;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPause() {
        return pause;
    }

    public void setPause(String pause) {
        this.pause = pause;
    }

    public String getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(String retryCount) {
        this.retryCount = retryCount;
    }

    public String getZookeeper() {
        return zookeeper;
    }

    public void setZookeeper(String zookeeper) {
        this.zookeeper = zookeeper;
    }

    public int getClientPort() {
        return clientPort;
    }

    public void setClientPort(int clientPort) {
        this.clientPort = clientPort;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "HbaseConfig{" +
                "zookeeper='" + zookeeper + '\'' +
                ", clientPort=" + clientPort +
                ", master='" + master + '\'' +
                ", pause='" + pause + '\'' +
                ", retryCount='" + retryCount + '\'' +
                '}';
    }
}
