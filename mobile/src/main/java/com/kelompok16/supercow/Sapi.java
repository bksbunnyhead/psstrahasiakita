package com.kelompok16.supercow;

/**
 * Created by Dandu on 2/19/17.
 */

public class Sapi {
    private String id;
    private String asset;
    private String status;
    private boolean wake;
    private short healt;
    private short happy;
    private short spiritOfLive;
    private short energy;

    /**
     * agar sapi bisa berbicara
     */
    public void sayMoo() {
        System.out.println("Mooooooooo\n");
    }

    /**
     * @id : mengembalikan id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @asset : mengembalikan asset
     */
    public String getAsset() {
        return asset;
    }

    public boolean isWake() {
        return wake;
    }

    public void setWake(boolean wake) {
        this.wake = wake;
    }

    public void setEnergy(short energy) {
        this.energy = energy;
    }

    public short getEnergy() {
        return energy;
    }

    public short getHealt() {
        return healt;
    }

    public short getHappy() {
        return happy;
    }

    public short getSpirit() {
        return spiritOfLive;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAsset(String asset) { this.asset = asset;}

    public void setStatus(String status) { this.status = status; }

    public void setHealt(short healt) { this.healt = healt; }

    public void setHappy(short happy) {this.happy = happy; }

    public void setSpiritOfLive(short spiritOfLive) { this.spiritOfLive = spiritOfLive; }

}
