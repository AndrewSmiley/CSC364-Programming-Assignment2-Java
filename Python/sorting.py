__author__ = 'Andrew'
from random import randint
import time,sys


"""
heap sort fns
"""
def heapify(arr, n, i):
    _max = i
    l = 2 * i + 1
    r = 2 * i + 2
    if l < n and arr[i] < arr[l]:
        _max = l
    if r < n and arr[_max] < arr[r]:
        _max = r
    if _max != i:
        arr[i],arr[_max] = arr[_max],arr[i]
        heapify(arr, n, _max)

def heapSort(arr):
    n = len(arr)
    for i in reversed(range(0, n+1)): #range(n, -1, -1):
        heapify(arr, n, i)
    for i in reversed(range(0, n)):#range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)

"""
Radix Sort fns
"""

def radix_count(array, exp):

    n = len(array)
    output = [0] * (n)
    count = [0] * (10)

    for i in range(0, n):
        index = (array[i]/exp)
        count[ index %10 ] = count[ index %10 ]+1

    for i in range(1,10):
        count[i] = count[i-1]+count[i]

    i = n-1
    while i>=0:
        index = (array[i]/exp)
        output[ count[ (index)%10 ] - 1] = array[i]
        count[ (index)%10 ] -= 1
        i -= 1
    for i in range(0,len(array)):
        array[i] = output[i]

def radix_sort(array):
    maxsize = sys.maxint
    exp = 1
    while maxsize/exp > 0:
        radix_count(array,exp)
        exp = exp*10

#slimmed this down based upon some reading online, vs what I had before w/ the potential benefit on linkedlists w/ iters
def insertion_sort(array):
    for i in range(1, len(array)):
        k,j = array[i], i-1
        while j >=0 and k < array[j]:
            array[j+1] = array[j]
            j =j-1
        array[j+1] = k



#could make this cleaner
#todo make this cleaner
ordered_one= [i for i in range(1, 100000)]
unordered_one = [randint(1, 100000) for i in range(1, 100001)]
ordered_two= [i for i in range(1, 200000)]
unordered_two = [randint(1, 200000) for i in range(1, 200001)]
print "="*25
print "Insertion Sort Outputs"
print "="*25
insertion_sort_tests = {"Ordered List of 100k": ordered_one, "Unordered List of 100k":unordered_one,
                   "Ordered List of 200k":ordered_two, "Unordered List of 200k": unordered_two }

for k, v in insertion_sort_tests.iteritems():
    print(k)
    start = time.time()
    heapSort(v)
    end=time.time()
    print ("Time elapsed: %s seconds \n" %(str((end-start)*1000)))

ordered_one= [i for i in range(1, 100000)]
unordered_one = [randint(1, 100000) for i in range(1, 100001)]
ordered_two= [i for i in range(1, 200000)]
unordered_two = [randint(1, 200000) for i in range(1, 200001)]
print "="*25
print "Heap Sort Outputs"
print "="*25
heap_sort_tests = {"Ordered List of 100k": ordered_one, "Unordered List of 100k":unordered_one,
                   "Ordered List of 200k":ordered_two, "Unordered List of 200k": unordered_two }


for k, v in heap_sort_tests.iteritems():
    print(k)
    start = time.time()
    heapSort(v)
    end=time.time()
    print ("Time elapsed: %s seconds \n" %(str((end-start)*1000)))

ordered_one= [i for i in range(1, 100000)]
unordered_one = [randint(1, 100000) for i in range(1, 100001)]
ordered_two= [i for i in range(1, 200000)]
unordered_two = [randint(1, 200000) for i in range(1, 200001)]

radix_sort_tests = {"Ordered List of 100k": ordered_one, "Unordered List of 100k":unordered_one,
                   "Ordered List of 200k":ordered_two, "Unordered List of 200k": unordered_two }

print "="*25
print "Radix Sort Outputs"
print "="*25
for k, v in radix_sort_tests.iteritems():
    print(k)
    start = time.time()
    radix_sort(v)
    end=time.time()
    print ("Time elapsed: %s seconds \n" %(str((end-start)*1000)))

print ""

