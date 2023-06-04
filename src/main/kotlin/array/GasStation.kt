package array

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
 * to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index
 * if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be unique
 */
class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var startIndex = 0
        var tank = 0
        var balance = 0
        for (i in gas.indices) {
            val diff = gas[i] - cost[i]
            tank += diff
            balance += diff
            if (tank < 0) {
                startIndex = i + 1
                tank = 0
            }
        }
        return if (balance < 0) -1 else startIndex
    }
}