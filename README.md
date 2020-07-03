## Locker
- Given 容量小于等于0 When 初始化Locker Then 初始化失败，抛出异常
- Given Locker有可用容量 When 存包 Then 存包成功，返回票据
- Given Locker没有可用容量 When 存包 Then 存包是否，提示储物柜已满
- Given 一张有效票据 When 取包 Then 取包成功
- Given 一张无效票据 When 取包 Then 取包失败，提示无效票据
- Given M号Locker When M号Locker存包 Then 存包失败，提示不支持操作
- Given M号Locker When M号Locker取包 Then 取包失败，提示不支持操作
- Given L号Locker When L号Locker存包 Then 取包失败，提示不支持操作
- Given L号Locker When L号Locker取包 Then 取包失败，提示不支持操作

## primary locker robot
- Given 包含有S号Locker列表 When 初始化Robot Then 初始化失败，抛出异常
- Given 空列表 When 初始化robot Then 初始化失败，抛出异常
- Given PrimaryLockerRobot管理两个M号Locker（locker1、locker2），两个locker都有可用容量 When PrimaryLockerRobot存包 Then 成功存入locker1，返回票据
- Given PrimaryLockerRobot管理两个M号Locker（locker1、locker2），locker1已满，locker2有可用容量 When PrimaryLockerRobot存包 Then 成功存入locker2，返回票据
- Given PrimaryLockerRobot管理两个M号Locker，两个locker都已满 When PrimaryLockerRobot存包 Then 存包失败，提示储物柜已满
- Given 一张有效PrimaryLockerRobot票据 When PrimaryLockerRobot取包 Then 取包成功
- Given 一张无效PrimaryLockerRobot票据 When PrimaryLockerRobot取包 Then 取包失败，提示无效票据
- Given 一张S号票据 When PrimaryLockerRobot取包 Then 取包失败，提示票据型号不对
- Given 一张L号票据 When PrimaryLockerRobot取包 Then 取包失败，提示票据型号不对

## supper locker robot
- Given 空列表 When 初始化robot Then 初始化失败，抛出配置异常错误异常
- Given 包含M号Locker列表 When 初始化Robot Then 初始化失败，抛出配置错误异常
- Given SupperLockerRobot管理两个M号Locker（locker1、locker2），locker1可用容量2，locker2可用容量1 When SupperLockerRobot存包 Then 成功存入locker1，返回票据
- Given SupperLockerRobot管理两个M号Locker（locker1、locker2），locker1可用容量1，locker2可用容量2 When SupperLockerRobot存包 Then 成功存入locker2，返回票据
- Given SupperLockerRobot管理两个M号Locker，两个locker都已满 When SupperLockerRobot存包 Then 存包失败，提示储物柜已满
- Given 一张有效SupperLockerRobot票据 When SupperLockerRobot取包 Then 取包成功
- Given 一张无效SupperLockerRobot票据 When SupperLockerRobot取包 Then 取包失败，提示无效票据
- Given 一张M号票据 When SupperLockerRobot取包 Then 取包失败，提示票据型号不对
- Given 一张S号票据 When SupperLockerRobot取包 Then 取包失败，提示票据型号不对

## locker robot manager
- Given PrimaryLockerRobot为空，SupperLockerRobot为空，Locker为空 When 初始化robot manager Then 初始化失败，提示配置错误
- Given PrimaryLockerRobot管理了其它Robot管理的locker When 初始化robot manager Then 初始化失败，提示配置错误
- Given SupperLockerRobot管理其它Robot管理的locker When 初始化robot manager Then 初始化失败，提示配置错误
- Given robot manager管理的locker有可用容量 When locker manager存包 Then 存包成功，返回票据
- Given robot manager管理的locker没有可用容量 When locker manager存包 Then 存包失败，提示储物柜已满
- Given robot manager管理PrimaryLockerRobot有可用容量 When locker manager存包 Then 存包成功，返回票据
- Given robot manager管理PrimaryLockerRobot无可用容量 When locker manager存包 Then 存包失败，提示储物柜已满
- Given robot manager管理的SupperLockerRobot有可用容量 When locker manager存包 Then 存包成功，返回票据
- Given robot manager管理的SupperLockerRobot无可用容量 When locker manager存包 Then 存包识别，提示储物柜已满
- Given 一张有效manager票据 When robot manager取票 Then 取包成功
- Given 一张无效manager票据 When robot manager取包 Then 取包失败，提示无效票据


