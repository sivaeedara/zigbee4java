package org.bubblecloud.zigbee.network.packet.zdo;

import org.bubblecloud.zigbee.network.packet.ZToolCMD;
import org.bubblecloud.zigbee.network.packet.ZToolPacket;
import org.bubblecloud.zigbee.util.DoubleByte;
import org.bubblecloud.zigbee.util.Integers;

/**
 * Created by seedara on 9/21/17.
 */
public class ZDO_EXT_SET_PARAMS extends ZToolPacket {
    /**
     * Group ID command message field.
     */
    private Integer disableMulticast = 128;

    /// <name>TI.ZPI1.ZDO_MGMT_LQI_REQ</name>
    /// <summary>Constructor</summary>
    public ZDO_EXT_SET_PARAMS() {
        int[] framedata = new int[1];
        framedata[0] = this.disableMulticast & 0xFF;
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_EXT_SET_PARAMS), framedata);
    }
}

