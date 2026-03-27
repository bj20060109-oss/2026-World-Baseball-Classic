# 2026-World-Baseball-Classic

### Introduction
In the high-stakes environment of the 2026 World Baseball Classic, a player's performance is often boosted by the Impact of the superstars in the lineup. A superstar’s Aura can inspire the surrounding teammates, boosting the team's overall momentum. However, this influence is limited by distance and can be blocked if another player with a similar or stronger Aura stands in the way.
As the Lead Data Analyst for the national team, you need to map out the Impact Zone for every player in the lineup to optimize the batting order.

### Description
The players are positioned in a straight line.
There are N players in the system, with an index i denoting their position in the sequence. i∈{0,1,…,N−1}
Each player has two key attributes: Aura Level and Impact Radius. These are represented as two sequences:

{Aura Level}  = {L_0, L_1, L_2, L_3...L_{N-1}}
{Impact Radius}  = {R_0, R_1, R_2, R_3...R_{N-1}}

A player at position i can exert influence over another player at position j if and only if the following conditions are met:

1.|j - i| <= R_i
  player_i must be within the range of player_j's Impact Radius.

2.L_j < L_i
  player_i must have a higher Aura Level than player_j's

3.{L_k} < L_i for all k in {k | i+1 <= k <= j-1} or k in {k | j+1 <= k <= i-1\}
  A player cannot influence another if there exists an intervening player with an equal or higher Aura Level in between.
  Ex: Level: [2,3,1], Radius: [2,2,2], the impact range of index 0 is (0,0), since 3>2.

For each player i, determine the smallest index (leftmost) and the largest index (rightmost) that they can successfully influence.

The final result should be represented as a flattened sequence of pairs:
{(a_0, b_0),..., (a_{N-1}, b_{N-1})}
