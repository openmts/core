package com.openvehicletracking.core;

import com.openvehicletracking.core.alarm.Alarm;
import com.openvehicletracking.core.db.DeviceDAO;
import com.openvehicletracking.core.message.Message;
import com.openvehicletracking.core.message.MessageHandler;
import io.vertx.core.Handler;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author oksuz
 *
 * Generic tracking device.
 */
public interface Device {

    /**
     * added to messages as deviceType
     * @return device name
     */
    String getName();

    /**
     * It provides tcp message handlers.
     * <p>
     *  when remote tracking device send message over http or tcp
     *  application try to find message handler for message calling this method.
     * </p>
     * @return Message handlers
     */
    CopyOnWriteArrayList<MessageHandler> getHandlers();

    /**
     *
     * @param message parsed device message
     * @param deviceDAO accessor for device meta and generated device alarms
     * @param handler alarm handler callback if alarm created then call handler like handler.handle(alarm)
     */
    void generateAlarmFromMessage(Message message, DeviceDAO deviceDAO, Handler<Alarm> handler);

    /**
     * update device meta or state using message
     * @param message parsed device message
     * @param deviceDAO accessor for device meta and generated device alarms
     */
    void updateMeta(Message message, DeviceDAO deviceDAO);
}
