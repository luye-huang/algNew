用一个队列装全部需要处理的元素
操作为一代又一代
每一代，循环队列中所有元素，并把每个元素相关的元素加到下一代中去。可有双队列，或者一个队列+维护每代队列的size来完成
循环完，标记数++