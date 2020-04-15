package dev.manolovn.flattendictionary;

import java.util.HashMap;
import java.util.Map;

public class TestInput {

    static Object[] case1() {
        Map<String, Object> input = new HashMap<String, Object>() {{
            put("Key1", "1");
            put("Key2", new HashMap<String, Object>() {{
                put("a", "2");
                put("b", "3");
                put("c", new HashMap<String, Object>() {{
                    put("d", "3");
                    put("e", "1");
                }});
            }});
        }};

        Map<String, String> expected = new HashMap<String, String>() {{
            put("Key1", "1");
            put("Key2.a", "2");
            put("Key2.b", "3");
            put("Key2.c.d", "3");
            put("Key2.c.e", "1");
        }};

        return new Object[]{input, expected};
    }

    static Object[] case2() {
        Map<String, Object> input = new HashMap<String, Object>() {{
            put("Key", new HashMap<String, Object>() {{
                put("a", "2");
                put("b", "3");
            }});
        }};

        Map<String, String> expected = new HashMap<String, String>() {{
            put("Key.a", "2");
            put("Key.b", "3");
        }};

        return new Object[]{input, expected};
    }

    static Object[] case3() {
        Map<String, Object> input = new HashMap<String, Object>() {{
            put("Key1", "1");
            put("Key2", new HashMap<String, Object>() {{
                put("a", "2");
                put("b", "3");
                put("c", new HashMap<String, Object>() {{
                    put("d", "3");
                    put("e", new HashMap<String, Object>() {{
                        put("f", "4");
                    }});
                }});
            }});
        }};

        Map<String, String> expected = new HashMap<String, String>() {{
            put("Key1", "1");
            put("Key2.a", "2");
            put("Key2.b", "3");
            put("Key2.c.d", "3");
            put("Key2.c.e.f", "4");
        }};

        return new Object[]{input, expected};
    }

    static Object[] case4() {
        Map<String, Object> input = new HashMap<String, Object>() {{
            put("", new HashMap<String, Object>() {{
                put("a", "1");
                put("b", "3");
            }});
        }};

        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "1");
            put("b", "3");
        }};

        return new Object[]{input, expected};
    }

    static Object[] case5() {
        Map<String, Object> input = new HashMap<String, Object>() {{
            put("a", new HashMap<String, Object>() {{
                put("b", new HashMap<String, Object>() {{
                    put("c", new HashMap<String, Object>() {{
                        put("d", new HashMap<String, Object>() {{
                            put("e", new HashMap<String, Object>() {{
                                put("f", new HashMap<String, Object>() {{
                                    put("", "awesome");
                                }});
                            }});
                        }});
                    }});
                }});
            }});
        }};

        Map<String, String> expected = new HashMap<String, String>() {{
            put("a.b.c.d.e.f", "awesome");
        }};

        return new Object[]{input, expected};
    }

    static Object[] case6() {
        Map<String, Object> input = new HashMap<String, Object>() {{
            put("a", "1");
        }};

        Map<String, String> expected = new HashMap<String, String>() {{
            put("a", "1");
        }};

        return new Object[]{input, expected};
    }
}
