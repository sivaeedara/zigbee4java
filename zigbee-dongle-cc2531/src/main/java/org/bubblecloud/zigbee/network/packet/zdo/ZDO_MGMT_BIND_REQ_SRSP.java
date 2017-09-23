package org.bubblecloud.zigbee.network.packet.zdo;

import org.bubblecloud.zigbee.network.packet.ResponseStatus;
import org.bubblecloud.zigbee.network.packet.ZToolCMD;
import org.bubblecloud.zigbee.network.packet.ZToolPacket;
import org.bubblecloud.zigbee.util.DoubleByte;

/**
 * Created by seedara on 9/20/17.
 */
public class ZDO_MGMT_BIND_REQ_SRSP extends ZToolPacket /*implements IRESPONSE,IZDO*/ {
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_REQ_SRSP.Status</name>
    /// <summary>Status</summary>
    public int Status;

    /// <name>TI.ZPI1.ZDO_MGMT_BIND_REQ_SRSP</name>
    /// <summary>Constructor</summary>
    public ZDO_MGMT_BIND_REQ_SRSP() {
    }

    public ZDO_MGMT_BIND_REQ_SRSP(int[] framedata) {
        this.Status = framedata[0];
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_MGMT_BIND_REQ_SRSP), framedata);
    }

    @Override
    public String toString() {
        return "ZDO_MGMT_BIND_REQ_SRSP{" +
                "Status=" + ResponseStatus.getStatus(Status) +
                '}';
    }
}

