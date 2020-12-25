package io.github.vshnv.mc.tictactoe.game;

import com.google.common.collect.*;

import java.util.UUID;


public final class InviteManager {
    private final Multimap<UUID, UUID> invitations;

    public InviteManager() {
        this.invitations = HashMultimap.create();
    }

    public ImmutableSet<UUID> getInvitations(UUID invitee) {
        return ImmutableSet.copyOf(invitations.get(invitee));
    }

    public boolean isInvited(UUID inviter, UUID invitee) {
        return invitations.get(inviter).contains(invitee);
    }

    public void addInvitation(UUID inviter, UUID invitee) {
        invitations.put(invitee, inviter);
    }

    public void revokeInvitation(UUID inviter, UUID invitee) {
        invitations.remove(inviter, invitee);
    }


}
