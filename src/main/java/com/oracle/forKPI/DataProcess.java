package com.oracle.forKPI;

import org.apache.hadoop.io.Text;

public class DataProcess {
    private String ip;//位置0
    private String time;//位置3
    private String pv;//位置6
    private String host;//位置10
    private String web;//位置11

    public static DataProcess dataCut(Text value) {
        String line = value.toString();
        String[] str = line.split(" ");
        DataProcess dataProcess = new DataProcess();
        dataProcess.setIp(str[0]);
        dataProcess.setHost(str[10]);
        dataProcess.setPv(str[6]);
        dataProcess.setTime(str[3]);
        dataProcess.setWeb(str[11]);
        return dataProcess;
    }

    @Override
    public String toString() {
        return "DataProcess{" +
                "ip='" + ip + '\'' +
                ", time='" + time + '\'' +
                ", pv='" + pv + '\'' +
                ", host='" + host + '\'' +
                ", web='" + web + '\'' +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}