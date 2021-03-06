package com.openvehicletracking.core;

import com.openvehicletracking.core.json.GsonFactory;
import com.openvehicletracking.core.json.JsonSerializeable;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oksuz on 20/08/2017.
 *
 */
public class DeviceState implements JsonSerializeable {


    private Position position;
    private long createdAt;
    private long updatedAt;
    private long deviceDate;

    private DeviceStatus deviceStatus;
    private VehicleStatus vehicleStatus;
    private GpsStatus gpsStatus;
    private Map<String, Object> attributes = new HashMap<>();
    private DeviceState oldState;

    public DeviceState() {
        this(null);
    }

    public DeviceState(@Nullable DeviceState oldState) {
        this.oldState = oldState;
    }

    @Override
    public String asJson() {
        return GsonFactory.getGson().toJson(this);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(long deviceDate) {
        this.deviceDate = deviceDate;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public GpsStatus getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(GpsStatus gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void addAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public DeviceState getOldState() {
        return oldState;
    }

    public void setOldState(DeviceState oldState) {
        this.oldState = oldState;
    }

    @Override
    public String toString() {
        return "DeviceState{" +
                "position=" + position +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deviceDate=" + deviceDate +
                ", deviceStatus=" + deviceStatus +
                ", vehicleStatus=" + vehicleStatus +
                ", gpsStatus=" + gpsStatus +
                ", attributes=" + attributes +
                '}';
    }
}
