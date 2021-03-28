# :link: Caching

Based on [`LRU`](https://ru.bmstu.wiki/LRU_(Least_Recently_Used)) algorithm with three types of policy
### `Write-through`
+ Ensures fast retrieval while making sure the data is in the backing store
- Writing data will experience latency as you have to write to two places every time

### `Write-around`
+ Not flooding the cache with data that may not subsequently be re-read
- Reading recently written data will result in a cache miss (and so a higher latency) because the data can only be read from the slower backing store

### `Write-behind` or `Write-back`
+ Low latency and high throughput for write-intensive applications
- There is data availability risk because the cache could fail