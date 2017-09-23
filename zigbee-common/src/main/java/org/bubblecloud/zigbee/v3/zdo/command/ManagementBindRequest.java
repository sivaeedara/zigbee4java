package org.bubblecloud.zigbee.v3.zdo.command;

import org.bubblecloud.zigbee.v3.ZdoRequest;
import org.bubblecloud.zigbee.v3.zdo.ZdoCommand;

/**
 * Created by seedara on 9/20/17.
 */
public class ManagementBindRequest extends ZdoCommand implements ZdoRequest {
    /**
     * The network address.
     */
    private int networkAddress;
    /**
     * The started index.
     */
    private int startIndex;

    public ManagementBindRequest() {
    }

    public ManagementBindRequest(int networkAddress, int startIndex) {
        this.networkAddress = networkAddress;
        this.startIndex = startIndex;
    }

    public int getNetworkAddress() {
        return networkAddress;
    }

    public void setNetworkAddress(int networkAddress) {
        this.networkAddress = networkAddress;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public String toString() {
        return "Management Bind Request " +
                "networkAddress=" + networkAddress +
                ", startIndex=" + startIndex;
    }

    @Override
    public int getDestinationAddress() {
        return networkAddress;
    }
}
