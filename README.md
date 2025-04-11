以下是针对竞争分析的 **双维度对比图表**，采用Mermaid语法实现横向竞品对标：

### 竞争分析对比图
```mermaid
flowchart LR
    subgraph 教育领域
        A[染乐工坊] --> B["<b>优势</b><br>✅ 系统化课程体系<br>✅ 资深染织师资"]
        A --> C["<b>劣势</b><br>❌ 高价策略（均价$800+）<br>❌ 无单次体验课<br>❌ 深水埗区位劣势"]
    end

    subgraph 文创领域
        D[TAK.L] --> E["<b>优势</b><br>✅ 高端材质工艺<br>✅ 天然染色技术<br>✅ 千元级溢价能力"]
        D --> F["<b>劣势</b><br>❌ 价格敏感度低<br>❌ 受众规模受限"]
    end

    style 教育领域 fill:#e8f5e9,stroke:#81c784
    style 文创领域 fill:#e3f2fd,stroke:#64b5f6
```

### 增强版表格对比（备用方案）
```mermaid
flowchart TD
    classDef comp fill:#fffde7,stroke:#ffd54f
    classDef pros fill:#e8f5e9,stroke:#81c784
    classDef cons fill:#ffebee,stroke:#ef9a9a

    subgraph 竞争维度对比["◼ 核心竞争维度对比"]
        direction LR
        subgraph 教育竞品["【教育类】“染乐工坊”传统染织工作坊"]
            A1["<b>定位</b>: 系统教学"]:::comp
            A2["✅ 师资专业度"]:::pros
            A3["✅ 课程深度"]:::pros
            A4["❌ 价格$800+"]:::cons
            A5["❌ 区位劣势"]:::cons
        end

        subgraph 文创竞品["【文创类】服装品牌TAK L"]
            B1["<b>定位</b>: 高端服饰"]:::comp
            B2["✅ 千元溢价"]:::pros
            B3["✅ 材质工艺"]:::pros
            B4["❌ 受众狭窄"]:::cons
        end
    end
```

**图表亮点说明：**
1. **双色区分领域**：教育（绿色系）vs 文创（蓝色系）
2. **符号化标注**：
   - ✅ 优势项用绿色对勾
   - ❌ 劣势项用红色叉号
3. **关键数据强化**：
   - 突出价格锚点（$800+/千元级）
   - 标注核心竞争维度（系统教学/高端服饰）

**扩展建议：**
- 可增加SWOT四象限图展示全局竞争态势
- 添加市场占有率数据标签（若有）
- 用价格带曲线对比定位差异

如需调整对比维度或增加产品线细节，可告知具体需求方向。

以下是针对目标客户群体的 **多维度用户画像图表**，采用Mermaid语法实现可视化呈现：

### 1. 客户群体雷达图（核心特征）
```mermaid
radarChart
    title 目标客户群体画像
    axis 年龄分布,性别比例,收入水平,艺术兴趣,需求痛点
    "染乐工坊" : 90, 70, 80, 95, 85
    scale 0,100
    fill "染乐工坊" #81c78455
    stroke "染乐工坊" #81c784
```

### 2. 详细属性分解图
```mermaid
flowchart TD
    classDef attr fill:#f5f5f5,stroke:#616161
    classDef value fill:#e3f2fd,stroke:#2196f3

    subgraph 客户画像["🎯 目标客户群体特征"]
        direction TB
        A1["属性"]:::attr --> A2["具体特征"]:::value
        B1["年龄"]:::attr --> B2["7-45岁（核心：25-35岁女性+7-12岁亲子）"]:::value
        C1["性别"]:::attr --> C2["女性占比70%+"]:::value
        D1["收入"]:::attr --> D2["月均可支配收入≥2万港币"]:::value
        E1["兴趣"]:::attr --> E2["传统手工艺/环保艺术/文创产品"]:::value
        F1["痛点"]:::attr --> F2["追求独特文化体验+个性化作品"]:::value
    end
```

### 3. 客户需求气泡图（备选方案）
```mermaid
flowchart LR
    classDef bubble fill:#bbdefb,stroke:#1976d2
    classDef text fill:transparent,stroke:transparent

    subgraph 需求强度["◼ 客户需求优先级"]
        direction TB
        A(("年龄分层")):::bubble --> |"亲子7-12岁\n占比35%"| B(("文化传承")):::bubble
        A --> |"青年25-35岁\n占比50%"| C(("社交体验")):::bubble
        A --> |"中年35-45岁\n占比15%"| D(("艺术收藏")):::bubble
        style A width:120px,height:120px
        style B width:90px,height:90px
        style C width:110px,height:110px
        style D width:80px,height:80px
    end
```

**图表设计说明：**
1. **可视化编码**：
   - 绿色系：核心客户特征（雷达图）
   - 蓝灰配：结构化属性分解（流程图）
   - 气泡大小：需求强度量化（备选方案）

2. **关键数据突出**：
   - 用百分比标注性别比例
   - 收入水平转化为具体数值标准
   - 年龄分段显示核心区间

3. **交互扩展建议**：
   - 可增加「客户旅程地图」展示参与动机
   - 添加真实用户语录作为悬浮注释
   - 用图标区分不同年龄段特征

如需调整维度权重或增加竞品对比层，可提供具体参数优化图表。
