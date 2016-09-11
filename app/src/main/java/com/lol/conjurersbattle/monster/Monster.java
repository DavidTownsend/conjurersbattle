package com.lol.conjurersbattle.monster;

import com.lol.conjurersbattle.common.Constants;

public class Monster {
    Integer attack;
    Integer defence;
    Integer speed;
    Integer hp;
    Integer element;

    public int elementAdvantage() throws Exception {
        if (element == Constants.WATER_TYPE) {
            return Constants.FIRE_TYPE;
        } else if (element == Constants.FIRE_TYPE) {
            return Constants.WIND_TYPE;
        } else if (element == Constants.WIND_TYPE) {
            return Constants.WATER_TYPE;
        } else {
            throw new Exception();
        }
    }

    public boolean hasElementalAdvantage(Integer enemyElement) throws Exception {
        if (element == Constants.FIRE_TYPE) {
            if (enemyElement == Constants.WIND_TYPE) {
                return true;
            } else {
                return false;
            }
        } else if (element == Constants.WATER_TYPE) {
            if (enemyElement == Constants.WATER_TYPE) {
                return true;
            } else {
                return false;
            }
        } else if (element == Constants.WIND_TYPE) {
            if (enemyElement == Constants.WATER_TYPE) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new Exception();
        }
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }
}
