# Mdcat

`Mdcat` is CLI tool to cat markdown file in terminal.
It is written in Java and uses Python library `Rich` for syntax highlighting.

:earth_americas: [中文](README.md) | English

# Usage

```bash
Help:
  mdcat [OPTIONS] [FILE]

    -h, --help
        Show this help message and exit.

  $ java mdcat README_EN.md
  or
  $ cat README_EN.md | java mdcat
```

# Requirements

- JDK11 or later
- Use `pip install rich` to install `rich` library