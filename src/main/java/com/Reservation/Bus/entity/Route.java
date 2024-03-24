package com.Reservation.Bus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Route {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String fromLocation;
        private String toLocation;
        private String fromDate;
        private String toDate;
        private String totalDuration;
        private String fromTime;
        private String toTime;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFromLocation() {
            return fromLocation;
        }

        public void setFromLocation(String fromLocation) {
            this.fromLocation = fromLocation;
        }

        public String getToLocation() {
            return toLocation;
        }

        public void setToLocation(String toLocation) {
            this.toLocation = toLocation;
        }

        public String getFromDate() {
            return fromDate;
        }

        public void setFromDate(String fromDate) {
            this.fromDate = fromDate;
        }

        public String getToDate() {
            return toDate;
        }

        public void setToDate(String toDate) {
            this.toDate = toDate;
        }

        public String getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(String totalDuration) {
            this.totalDuration = totalDuration;
        }

        public String getFromTime() {
            return fromTime;
        }

        public void setFromTime(String fromTime) {
            this.fromTime = fromTime;
        }

        public String getToTime() {
            return toTime;
        }

        public void setToTime(String toTime) {
            this.toTime = toTime;
        }

        public long getBusId() {
            return busId;
        }

        public void setBusId(long busId) {
            this.busId = busId;
        }

        @Column(name = "bus_id",unique = true,nullable = false)
        private long busId;
    }
