package org.bubblecloud.zigbee.v3.zdo.command;

import org.bubblecloud.zigbee.v3.ZdoRequest;
import org.bubblecloud.zigbee.v3.zdo.ZdoCommand;

/**
 * Created by seedara on 9/19/17.
 */
public class AddLocalGroup extends ZdoCommand implements ZdoRequest {
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

    public AddLocalGroup() {
    }

    public AddLocalGroup(Integer groupId, String groupName, Integer endPointId) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.endPointId = endPointId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getEndPointId() {
        return endPointId;
    }

    public void setEndPointId(Integer endPointId) {
        this.endPointId = endPointId;
    }

    @Override
    public String toString() {
        return "AddLocalGroup{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", endPointId=" + endPointId +
                '}';
    }

    @Override
    public int getDestinationAddress() {
        return 0;
    }
}
