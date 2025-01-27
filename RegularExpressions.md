正则表达式（Regular Expressions，简称 Regex）是一种强大的文本匹配工具，广泛用于字符串搜索、替换和验证。以下是正则表达式的语法大全，涵盖了常用的语法和示例：

---

## 1. **基本语法**
| 语法       | 描述                                                                 |
|------------|--------------------------------------------------------------------|
| `.`        | 匹配任意单个字符（除了换行符 `\n`）。                                   |
| `\d`       | 匹配数字字符（等价于 `[0-9]`）。                                        |
| `\D`       | 匹配非数字字符（等价于 `[^0-9]`）。                                     |
| `\w`       | 匹配字母、数字或下划线（等价于 `[a-zA-Z0-9_]`）。                        |
| `\W`       | 匹配非字母、数字或下划线的字符（等价于 `[^a-zA-Z0-9_]`）。                |
| `\s`       | 匹配空白字符（包括空格、制表符、换行符等）。                              |
| `\S`       | 匹配非空白字符。                                                       |
| `[...]`    | 匹配括号内的任意一个字符（例如 `[abc]` 匹配 `a`、`b` 或 `c`）。           |
| `[^...]`   | 匹配不在括号内的任意一个字符（例如 `[^abc]` 匹配非 `a`、`b`、`c` 的字符）。|
| `|`        | 逻辑“或”，匹配左边或右边的表达式（例如 `a|b` 匹配 `a` 或 `b`）。           |

---

## 2. **量词**
| 语法       | 描述                                                                 |
|------------|--------------------------------------------------------------------|
| `*`        | 匹配前面的表达式 0 次或多次。                                          |
| `+`        | 匹配前面的表达式 1 次或多次。                                          |
| `?`        | 匹配前面的表达式 0 次或 1 次。                                         |
| `{n}`      | 匹配前面的表达式恰好 `n` 次。                                          |
| `{n,}`     | 匹配前面的表达式至少 `n` 次。                                          |
| `{n,m}`    | 匹配前面的表达式至少 `n` 次，至多 `m` 次。                              |

---

## 3. **边界匹配**
| 语法       | 描述                                                                 |
|------------|--------------------------------------------------------------------|
| `^`        | 匹配字符串的开头。                                                   |
| `$`        | 匹配字符串的结尾。                                                   |
| `\b`       | 匹配单词边界（例如 `\bword\b` 匹配独立的单词 `word`）。                |
| `\B`       | 匹配非单词边界。                                                     |

---

## 4. **分组与捕获**
| 语法           | 描述                                                                 |
|----------------|--------------------------------------------------------------------|
| `(...)`        | 捕获分组，将括号内的内容作为一个整体匹配并捕获。                         |
| `(?:...)`      | 非捕获分组，匹配但不捕获内容。                                         |
| `(?<name>...)` | 命名捕获分组，将匹配的内容命名为 `name`（例如 `(?<year>\d{4})`）。      |
| `\1`, `\2`     | 引用捕获分组的内容（例如 `(\w+)\s\1` 匹配重复的单词）。                  |

---

## 5. **零宽断言**
| 语法           | 描述                                                                 |
|----------------|--------------------------------------------------------------------|
| `(?=...)`      | 正向先行断言，匹配后面满足条件的位置。                                 |
| `(?!...)`      | 负向先行断言，匹配后面不满足条件的位置。                               |
| `(?<=...)`     | 正向后行断言，匹配前面满足条件的位置。                                 |
| `(?<!...)`     | 负向后行断言，匹配前面不满足条件的位置。                               |

---

## 6. **转义字符**
| 语法       | 描述                                                                 |
|------------|--------------------------------------------------------------------|
| `\`        | 转义特殊字符（例如 `\.` 匹配实际的句点 `.`）。                        |
| `\n`       | 匹配换行符。                                                        |
| `\t`       | 匹配制表符。                                                        |
| `\r`       | 匹配回车符。                                                        |

---

## 7. **常用正则表达式示例**
| 用途               | 正则表达式                                                                 |
|--------------------|--------------------------------------------------------------------------|
| 匹配邮箱           | `^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$`                       |
| 匹配手机号         | `^1[3-9]\d{9}$`                                                          |
| 匹配身份证号       | `^\d{17}[\dXx]$`                                                         |
| 匹配 URL           | `^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$`         |
| 匹配日期（YYYY-MM-DD） | `^\d{4}-\d{2}-\d{2}$`                                                   |
| 匹配 IP 地址       | `^((25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)\.){3}(25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)$` |

---

## 8. **工具推荐**
- **Regex101**：在线正则表达式测试工具，支持多种语言。
    - 官网：[https://regex101.com/](https://regex101.com/)
- **RegExr**：另一个在线正则表达式学习和测试工具。
    - 官网：[https://regexr.com/](https://regexr.com/)

---