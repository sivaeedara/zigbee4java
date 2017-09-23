package org.bubblecloud.zigbee.network.packet.zdo;

import org.bubblecloud.zigbee.network.packet.ZToolCMD;
import org.bubblecloud.zigbee.network.packet.ZToolPacket;
import org.bubblecloud.zigbee.util.DoubleByte;
import org.bubblecloud.zigbee.util.Integers;
import org.bubblecloud.zigbee.v3.model.ZToolAddress16;

/**
 * Created by seedara on 9/19/17.
 */
public class ZDO_EXT_ADD_GROUP extends ZToolPacket {
    /**
     * Group ID command message field.
     */
    private Integer groupId;
    /**
     * Group Name command message field.
     */
    private String groupName;

    /**
     * Endpoint ID command message field.
     */
    private Integer endPointId;

    /// <name>TI.ZPI1.ZDO_EXT_ADD_GROUP</name>
    /// <summary>Constructor</summary>
    public ZDO_EXT_ADD_GROUP() {
    }

    /// <name>TI.ZPI1.ZDO_MGMT_LQI_REQ</name>
    /// <summary>Constructor</summary>
    public ZDO_EXT_ADD_GROUP(int groupId, String groupName, int endPointId) {
        this.groupId =groupId;
        this.groupName =groupName;
        this.endPointId = endPointId;

        int[] framedata = new int[20];
        framedata[0] = this.endPointId;
        framedata[1] = Integers.getByteAsInteger(this.groupId, 0); // Source address
        framedata[2] = Integers.getByteAsInteger(this.groupId, 1); // Source address

        final byte[] groupNameBytes = this.groupName.getBytes();
        for (int i = 0; i < groupNameBytes.length; i++) {
            framedata[i +3] = groupNameBytes[i];
        }
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_EXT_ADD_GROUP), framedata);
    }
}
