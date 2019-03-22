package com.company.manerger.sys.common.queue.listener;

import com.company.manerger.sys.common.queue.utils.EventUtils;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MemberAttributeEvent;
import com.hazelcast.core.MembershipEvent;
import com.hazelcast.core.MembershipListener;

public class ClusterMemberShipTopicListener implements MembershipListener {
    private HazelcastInstance hazelcastInstance;

    public ClusterMemberShipTopicListener(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public void memberAdded(MembershipEvent membershipEvent) {
        EventUtils.voteHazelcastMaster(hazelcastInstance);
    }

    @Override
    public void memberRemoved(MembershipEvent membershipEvent) {
        EventUtils.voteHazelcastMaster(hazelcastInstance);
    }

    @Override
    public void memberAttributeChanged(MemberAttributeEvent memberAttributeEvent) {

    }
}
