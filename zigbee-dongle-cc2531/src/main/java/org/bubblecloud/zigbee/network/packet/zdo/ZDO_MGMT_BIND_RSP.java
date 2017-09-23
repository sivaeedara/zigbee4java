package org.bubblecloud.zigbee.network.packet.zdo;

import org.bubblecloud.zigbee.network.packet.ResponseStatus;
import org.bubblecloud.zigbee.network.packet.ZToolCMD;
import org.bubblecloud.zigbee.network.packet.ZToolPacket;
import org.bubblecloud.zigbee.util.ByteUtils;
import org.bubblecloud.zigbee.util.DoubleByte;
import org.bubblecloud.zigbee.v3.model.ZToolAddress16;
import org.bubblecloud.zigbee.v3.model.ZToolAddress64;

import java.util.Arrays;

/**
 * Created by seedara on 9/20/17.
 */
public class ZDO_MGMT_BIND_RSP extends ZToolPacket /*implements IRESPONSE_CALLBACK,IZDo*/ {
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_RSP.BindingTableListCount</name>
    /// <summary>Number of entries in this response.</summary>
    public int BindingTableListCount;
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_RSP.BindingTableEntries</name>
    /// <summary>Total number of entries available in the device.</summary>
    public int BindingTableEntries;
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_RSP.NeighborLqiList</name>
    /// <summary>Dynamic array, Number of entries in this response.</summary>
    public BindingTableListItemClass[] BindingTableList;
    //private NeighborLqiListItemClass NeighborLqiListItemClassDummyObj;
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_RSP.SrcAddress</name>
    /// <summary>Source address of the message</summary>
    public ZToolAddress16 SrcAddress;
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_RSP.StartIndex</name>
    /// <summary>Where in the total number of entries this response starts.</summary>
    public int StartIndex;
    /// <name>TI.ZPI1.ZDO_MGMT_BIND_RSP.Status</name>
    /// <summary>this field indicates either SUCCESS or FAILURE.</summary>
    public int Status;

    /// <name>TI.ZPI1.ZDO_MGMT_BIND_RSP</name>
    /// <summary>Constructor</summary>
    public ZDO_MGMT_BIND_RSP() {
        this.BindingTableList = new BindingTableListItemClass[]{};
    }

    public ZDO_MGMT_BIND_RSP(int[] framedata) {
        this.SrcAddress = new ZToolAddress16(framedata[1], framedata[0]);
        this.Status = framedata[2];
        if (framedata.length > 3)
        {
            this.BindingTableEntries = framedata[3];
            this.StartIndex = framedata[4];
            this.BindingTableListCount = framedata[5];
            this.BindingTableList = new BindingTableListItemClass[framedata[5]];

            int NOpt1;
            int NOpt2;

            int k = 0;
            byte[] bytes = new byte[8];
            for (int z = 0; z < this.BindingTableList.length; z++) {
                for (int j = 0; j < 8; j++) {
                    bytes[7 - j] = (byte) framedata[6 + k + j];///MSB><LSB?
                }
                final ZToolAddress64 sourceAddress = new ZToolAddress64(bytes);

                final int srcEndpoint = framedata[14 + k];
               final int clusterId = framedata[15 + k];
               final int destinationAddressMode = framedata[16 + k];

                for (int j = 0; j < 8; j++) {
                    bytes[7 - j] = (byte) framedata[17 + k + j];///MSB><LSB?
                }
                final ZToolAddress64 destinationAddress = new ZToolAddress64(bytes);

                final int destinationEndpoint = framedata[22 + k];
                this.BindingTableList[z] = new BindingTableListItemClass(sourceAddress, srcEndpoint, clusterId, destinationAddressMode, destinationAddress, destinationEndpoint);
                k += 20;
            }
        }
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_MGMT_BIND_RSP), framedata);
    }


    /// <name>TI.ZPI1.ZDO_MGMT_BIND_RSP.BindingTableListItemClass</name>
    /// <summary>Contains information in a single item of a binding table</summary>
    public class BindingTableListItemClass {

        public ZToolAddress64 SourceAddress;
        public int SourceEndPoint;
        public int ClusterId;
        public int DestinationAddressingMode;
        public ZToolAddress64 DestinationAddress;
        public int DestinationEndPoint;

        public BindingTableListItemClass() {
        }

        public BindingTableListItemClass(ZToolAddress64 num1, int num2, int num3, int num4, ZToolAddress64 num5, int num6) {
            this.SourceAddress = num1;
            this.SourceEndPoint = num2;
            this.ClusterId = num3;
            this.DestinationAddressingMode = num4;
            this.DestinationAddress = num5;
            this.DestinationEndPoint = num6;
        }
    }

    /**
     * @return the number of Neighbor LQI entries present on the message
     */
    public int getBindingTableCount() {
        if (this.BindingTableList != null)
        {
            return this.BindingTableList.length;
        } else {
            return 0;
        }
    }

    /**
     * @return the index of the first entries available on the message with respect
     *         to the Neighbor LQI Tables on the device
     */
    public int getStartIndex() {
        return StartIndex;
    }

    /**
     * @return the number of Neighbor LQI entries available on the device
     */
    public int getBindingTableEntries() {
        return this.BindingTableEntries;
    }

    public BindingTableListItemClass[] getBindingTableList() {
        return BindingTableList;
    }

    @Override
    public String toString() {
        return "ZDO_MGMT_BIND_RSP{" +
                "BindingTableListCount=" + BindingTableListCount +
                ", BindingTableEntries=" + BindingTableEntries +
                ", BindingTableList=" + Arrays.toString(BindingTableList) +
                ", SrcAddress=" + SrcAddress +
                ", StartIndex=" + StartIndex +
                ", Status=" + ResponseStatus.getStatus(Status) +
                '}';
    }

    /// <name>TI.ZPI1.ZDO_BIND_REQ.ADDRESS_MODE</name>
    /// <summary>Specified the format of the coordinator address</summary>
    public class ADDRESS_MODE {
        /// <name>TI.ZPI1.ZDO_BIND_REQ.ADDRESS_MODE.ADDRESS_16_BIT</name>
        /// <summary>Specified the format of the coordinator address</summary>
        public static final int ADDRESS_16_BIT = 2;
        /// <name>TI.ZPI1.ZDO_BIND_REQ.ADDRESS_MODE.ADDRESS_64_BIT</name>
        /// <summary>Specified the format of the coordinator address</summary>
        public static final int ADDRESS_64_BIT = 3;
        /// <name>TI.ZPI1.ZDO_BIND_REQ.ADDRESS_MODE.ADDRESS_NOT_PRESENT</name>
        /// <summary>Specified the format of the coordinator address</summary>
        public static final int ADDRESS_NOT_PRESENT = 0;
        /// <name>TI.ZPI1.ZDO_BIND_REQ.ADDRESS_MODE.BROADCAST</name>
        /// <summary>Specified the format of the coordinator address</summary>
        public static final int BROADCAST = 15;
        /// <name>TI.ZPI1.ZDO_BIND_REQ.ADDRESS_MODE.GROUP_ADDRESS</name>
        /// <summary>Specified the format of the coordinator address</summary>
        public static final int GROUP_ADDRESS = 1;
    }
}

