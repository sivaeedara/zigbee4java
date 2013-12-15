/*
   Copyright 2012-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies
   of the Italian National Research Council


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.proxy.device.impl;

import org.bubblecloud.zigbee.network.glue.ZigBeeDevice;
import org.bubblecloud.zigbee.proxy.cluster.glue.general.Groups;
import org.bubblecloud.zigbee.proxy.cluster.glue.measureament_sensing.IlluminanceMeasurement;
import org.bubblecloud.zigbee.proxy.device.api.lighting.LightSensor;
import org.bubblecloud.zigbee.proxy.HADeviceBase;
import org.bubblecloud.zigbee.proxy.HAProfile;
import org.bubblecloud.zigbee.proxy.ZigBeeHAException;
import org.bubblecloud.zigbee.proxy.AbstractDeviceDescription;
import org.bubblecloud.zigbee.proxy.DeviceDescription;
import org.bubblecloud.zigbee.BundleContext;

/**
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco</a>
 *
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.7.0
 *
 */
public class LightSensorDevice extends HADeviceBase implements LightSensor {

    private IlluminanceMeasurement illuminanceMeasurement;
    private Groups groups;

    public LightSensorDevice(BundleContext ctx, ZigBeeDevice zbDevice) throws ZigBeeHAException {

        super(ctx, zbDevice);

        illuminanceMeasurement = (IlluminanceMeasurement) getCluster(HAProfile.ILLUMINANCE_MEASUREMENT);
        groups = (Groups) getCluster(HAProfile.GROUPS);
    }

    public IlluminanceMeasurement getIlluminanceMeasurement() {

        return illuminanceMeasurement;
    }

    @Override
    public String getName() {

        return LightSensor.NAME;
    }

    @Override
    public DeviceDescription getDescription() {

        return DEVICE_DESCRIPTOR;
    }

    final static DeviceDescription DEVICE_DESCRIPTOR =  new AbstractDeviceDescription(){

        public int[] getCustomClusters() {
            return LightSensor.CUSTOM;
        }

        public int[] getMandatoryCluster() {
            return LightSensor.MANDATORY;
        }

        public int[] getOptionalCluster() {
            return LightSensor.OPTIONAL;
        }

        public int[] getStandardClusters() {
            return LightSensor.STANDARD;
        }

    };

    public Groups getGroups() {
        return groups;
    }
}