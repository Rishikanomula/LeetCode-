class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        # Ensure nums1 is the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        
        m, n = len(nums1), len(nums2)
        total = m + n
        half = total // 2
        
        left, right = 0, m
        while left <= right:
            i = (left + right) // 2  # partition in nums1
            j = half - i             # partition in nums2
            
            # Left and right values around the partition
            nums1_left = nums1[i-1] if i > 0 else float("-inf")
            nums1_right = nums1[i] if i < m else float("inf")
            nums2_left = nums2[j-1] if j > 0 else float("-inf")
            nums2_right = nums2[j] if j < n else float("inf")
            
            # Check if partition is correct
            if nums1_left <= nums2_right and nums2_left <= nums1_right:
                # Odd total length
                if total % 2:
                    return float(min(nums1_right, nums2_right))
                # Even total length
                return (max(nums1_left, nums2_left) + min(nums1_right, nums2_right)) / 2.0
            elif nums1_left > nums2_right:
                right = i - 1
            else:
                left = i + 1
