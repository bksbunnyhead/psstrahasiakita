package com.kelompok16.supercow;

/**
 * Created by Dandu on 2/19/17.
 */

public class Sapi {
    private String id;
    private String asset;
    private String status;
    private short healt;
    private short happy;
    private short spiritOfLive;
/*
    /**
     * agar sapi bisa berbicara

    public String sayMoo() {
        System.out.println("Mooooooooo\n");
    }
*/
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
/*
    public setId(String id) {
        this.id = id;
    }

    public setAsset(String asset) { this.asset = asset;}

    public setStatus(String status) { this.status = status; }

    public setHealt(short healt) { this.healt = healt; }

    public setHappy(short happy) {this.happy = happy; }

    public setSpiritOfLive(short spiritOfLive) { this.spiritOfLive = spiritOfLive; }
*/
}
