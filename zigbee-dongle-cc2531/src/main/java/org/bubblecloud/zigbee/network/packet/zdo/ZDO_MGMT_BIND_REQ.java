package org.bubblecloud.zigbee.network.packet.zdo;

import org.bubblecloud.zigbee.network.packet.ZToolCMD;
import org.bubblecloud.zigbee.network.packet.ZToolPacket;
import org.bubblecloud.zigbee.util.DoubleByte;
import org.bubblecloud.zigbee.v3.model.ZToolAddress16;

/**
 * Created by seedara on 9/20/17.
 */
public class ZDO_MGMT_BIND_REQ extends ZToolPacket {
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_REQ.DstAddr</name>
    /// <summary>Destination network address.</summary>
    public ZToolAddress16 DstAddr;
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_REQ.StartIndex</name>
    /// <summary>Where to start.  The result can be more networks than can be reported, so this field allows a user to ask for more.</summary>
    public int StartIndex;

    /// <name>TI.ZPI1.ZDO_MGMT_BIND_REQ</name>
    /// <summary>Constructor</summary>
    public ZDO_MGMT_BIND_REQ() {
    }

    /// <name>TI.ZPI1.ZDO_MGMT_BIND_REQ</name>
    /// <summary>Constructor</summary>
    public ZDO_MGMT_BIND_REQ(ZToolAddress16 num1, int num2) {
        this.DstAddr = num1;
        this.StartIndex = num2;

        int[] framedata = new int[3];
        framedata[0] = this.DstAddr.getLsb();
        framedata[1] = this.DstAddr.getMsb();
        framedata[2] = this.StartIndex;
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_MGMT_BIND_REQ), framedata);
    }
}
