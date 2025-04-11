flowchart TD
    classDef comp fill:#fffde7,stroke:#ffd54f
    classDef pros fill:#e8f5e9,stroke:#81c784
    classDef cons fill:#ffebee,stroke:#ef9a9a

    subgraph 竞争维度对比["◼ 核心竞争维度对比"]
        direction LR
        subgraph 教育竞品["【教育类】染乐工坊"]
            A1["<b>定位</b>: 系统教学"]:::comp
            A2["✅ 师资专业度"]:::pros
            A3["✅ 课程深度"]:::pros
            A4["❌ 价格$800+"]:::cons
            A5["❌ 区位劣势"]:::cons
        end

        subgraph 文创竞品["【文创类】TAK.L"]
            B1["<b>定位</b>: 高端服饰"]:::comp
            B2["✅ 千元溢价"]:::pros
            B3["✅ 材质工艺"]:::pros
            B4["❌ 受众狭窄"]:::cons
        end
    end
