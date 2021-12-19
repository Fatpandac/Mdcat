# Mdcat 

`Mdcat` 是一个 CLI 工具，你可以使用它在终端上简单查看 `.md` 文件。
无需离开终端即可查看 `.md` 文件内容,对于 vimer 来说这是一个十分友好的工具，
毕竟对绝大多数 vimer 来说离开终端简直就是阎王的令箭——要命！:joy:

:earth_asia: 中文 | [English](README_EN.md)

# 使用
```shell
Help:
  mdcat [OPTIONS] [FILE]

    -h, --help
        Show this help message and exit.

  $ java mdcat README_EN.md
  or
  $ cat README_EN.md | java mdcat
```

# 要求

- JDK11 或更新
- 使用 `pip install rich` 安装 `rich` 库，
这是一个 Python 库用于渲染代码块中的代码高亮。

# 支持的 Markdown 语法

## Head

# H1
## H2
### H3
#### H4
##### H5
###### H6

## Table

| 中文    | English      | 日本语      | 한국인   |
|-------|--------------|----------|-------|
| 你好    | Hello        | こんにちは    | 안녕하세요 |
| 你好世界! | Hello World! | こんにちは世界！ | 헬로월드  |

## Bold Italic Strike

**Bold**

*Italic*

~~Strike~~

**_Bold and Italic_**

**~~Bold and Strike~~**

~~*Italic and Strike*~~

**_~~Bold and Italic and Strike~~_**

## Quote

> This is a quote

> Hello World!
>> 你好世界!
>>> こんにちは世界！
>>>> 헬로월드

## Unordered List

- 1
- 2
    - 3
    - 4
- 5

## Order List

```markdown
1. A
3. Order
2. List

2. New
4. Order
7. List
```

1. A
3. Order
2. List

2. New
4. Order
7. List

## Code

`C`

```c
#include <stdio.h>

int main()
{
    printf("Hello World");
    return 0;
}
```

`Python`

```python
print("Hello World!")
```

## Emoji

- :tada:
    - :zap:
- :art:
    - :bug:
- :fire:
    - :rocket:

## Checkbox

- [x] Checkbox
- [ ] Checkbox

## 配置渲染样式

配置文件位置为 `assets/style.txt`

以下的配置项都为 `NAME:VALUE` 的形式
有以下配置项：
- `CheckBox` 用于配置 Check Box 样式，默认为 `[✓]`
- `UncheckBox` 用于配置 Uncheck Box 样式，默认为 `[ ]`
- Head 的颜色配置，全部为 RGB 模式，格式为 `(R, G, B)`
  - `H1Color` 默认为 `(32, 12, 234)`
  - `H2Color` 默认为 `(234, 45, 134)`
  - `H3Color` 默认为 `(34, 56, 128)`
  - `H4Color` 默认为 `(65, 45, 255)`
  - `H5Color` 默认为 `(45, 67, 89)`
  - `H6Color` 默认为 `(89, 123, 67)`
- Head 的标签样式配置
  - `H1Sign` 默认为 `██`
  - `H2Sign` 默认为 `▓▓▓`
  - `H3Sign` 默认为 `▒▒▒▒`
  - `H4Sign` 默认为 `░░░░░`
  - `H5Sign` 默认为空
  - `H6Sign` 默认为空
- `TableUnderlineSign` 用于配置表格线样式，默认为 `─`
- `UnorderedListSign` 用于配置无序列表样式，默认为 `.`
- `QuoteSign` 用于配置引用样式，默认为 `│`

**例如** >>> assets/style.txt

```markdown
CheckBox: [✓]
UncheckBox: [ ]
H1Color: (32, 12, 234)
H1Sign: ██
H2Color: (234, 45, 134)
H2Color: ▓▓▓
H3Color: (34, 56, 128)
H3Sign: ▒▒▒▒
H4Color: (65, 45, 255)
H4Sign: ░░░░░
H5color: (45, 67, 89)
H5Sign:
H6color: (89, 123, 67)
H6Sign:
TableUnderlineSign: ─
UnorderedListSign: .
QuoteSign: │
```