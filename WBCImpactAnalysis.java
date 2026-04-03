class WBCImpactAnalysis {
    
    public int[] result(int[] auraLevels, int[] impactRadius) {
        
        int n = auraLevels.length;
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];
        int[] stack = new int[n];
        int top = -1;

        // Find nearest blocker on the left (first index with level >= current level).
        for (int i = 0; i < n; i++) {
            while (top >= 0 && auraLevels[stack[top]] < auraLevels[i]) {
                top--;
            }
            int blockerIndex = (top < 0) ? -1 : stack[top];
            leftBound[i] = Math.max(blockerIndex + 1, i - impactRadius[i]);
            stack[++top] = i;
        }

        // Find nearest blocker on the right (first index with level >= current level).
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && auraLevels[stack[top]] < auraLevels[i]) {
                top--;
            }
            int blockerIndex = (top < 0) ? n : stack[top];
            rightBound[i] = Math.min(blockerIndex - 1, i + impactRadius[i]);
            stack[++top] = i;
        }

        int[] flattenedResult = new int[n * 2];
        for (int i = 0; i < n; i++) {
            flattenedResult[i * 2] = leftBound[i];
            flattenedResult[i * 2 + 1] = rightBound[i];
        }

        return flattenedResult;
    }
}