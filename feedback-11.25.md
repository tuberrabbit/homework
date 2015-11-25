# feedback-11.25
## CollectionsOps
- odd() 和 doubleEvens() 的实现可以更巧妙些，参考@Kimmy Liu分享的demo
- tryFind() 中对象比较不推荐 ==，toString() & break 没用对，代码需要重构
 
## GuessNumberTest 
- 无用的构造函数 GuessNumberTest()
- throws Exception 使用错误，去掉
- 测试方法和测试文件都可以被驱动出来，经鉴定，不是，可以先自己了解下，如何做？

## GuessNumbers
- 代码结构复杂，请积极重构，参考《重构：改善既有的代码结构》

## GameMain
- 去掉无用的comments
- 代码结构混乱，难以阅读，建议在合适的地方，用空行划分，并积极重构
- 却少测试覆盖
