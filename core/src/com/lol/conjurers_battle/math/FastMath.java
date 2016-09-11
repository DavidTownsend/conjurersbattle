package com.lol.conjurers_battle.math;


import com.badlogic.gdx.math.Vector3;

public class FastMath {

    public static float interpolateLinear(float scale, float startValue, float endValue) {
        if (startValue == endValue) {
            return startValue;
        }
        if (scale <= 0f) {
            return startValue;
        }
        if (scale >= 1f) {
            return endValue;
        }
        return ((1f - scale) * startValue) + (scale * endValue);
    }

    public static Vector3 interpolateLinear(float scale, Vector3 startValue, Vector3 endValue) {
        Vector3 result = new Vector3();
        result.x = interpolateLinear(scale, startValue.x, endValue.x);
        result.y = interpolateLinear(scale, startValue.y, endValue.y);
        result.z = interpolateLinear(scale, startValue.z, endValue.z);
        return result;
    }

}
