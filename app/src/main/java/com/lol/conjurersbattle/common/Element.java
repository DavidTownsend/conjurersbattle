package com.lol.conjurersbattle.common;

public class Element {
    public enum ElementType {
        WIND, WATER, FIRE
    }

    private ElementType elementType;

    public static ElementType elementAdvantage(ElementType elementType) {
        if (elementType == ElementType.WATER) {
            return ElementType.FIRE;
        } else if (elementType == ElementType.FIRE) {
            return ElementType.WIND;
        } else if (elementType == ElementType.WIND) {
            return ElementType.WATER;
        }

        return null;
    }

    public boolean hasElementalAdvantage(ElementType enemyElement) {
        if (elementAdvantage(elementType) == enemyElement) {
            return true;
        }

        return false;
    }

    public boolean hasDisadvantageElement(ElementType enemyElement) {
        if (elementAdvantage(enemyElement) == elementType) {
            return true;
        }

        return false;
    }

    public boolean hasNeutralElement(ElementType enemyElement) {
        if (!hasElementalAdvantage(enemyElement) && !hasDisadvantageElement(enemyElement)) {
            return true;
        }

        return false;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

}
