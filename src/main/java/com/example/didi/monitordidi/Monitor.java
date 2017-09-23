package com.example.didi.monitordidi;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Didi on 14.06.2017.
 */


    public class Monitor implements Serializable {
        private int serviceNumber;
        private String producer;
        private int diagonal;
        private String owner;
        private Date serviceDate;

        public Monitor(int serviceNumber, String producer, int diagonal, String owner, Date serviceDate) {
            this.serviceNumber = serviceNumber;
            this.producer = producer;
            this.diagonal = diagonal;
            this.owner = owner;
            this.serviceDate = serviceDate;
        }

        public int getServiceNumber() {
            return serviceNumber;
        }

        public void setServiceNumber(int serviceNumber) {
            this.serviceNumber = serviceNumber;
        }

        public String getProducer() {
            return producer;
        }

        public void setProducer(String producer) {
            this.producer = producer;
        }

        public Date getServiceDate() {
            return serviceDate;
        }

        public void setServiceDate(Date serviceDate) {
            this.serviceDate = serviceDate;
        }

        public int getDiagonal() {
            return diagonal;
        }

        public void setDiagonal(int diagonal) {
            this.diagonal = diagonal;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        @Override
        public String toString() {
            return "Monitor{" +
                    "serviceNumber=" + serviceNumber +
                    ", producer='" + producer + '\'' +
                    ", serviceDate=" + serviceDate +
                    ", diagonal=" + diagonal +
                    ", owner='" + owner + '\'' +
                    '}';
        }
    }


