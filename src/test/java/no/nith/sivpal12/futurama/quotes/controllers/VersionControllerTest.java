package no.nith.sivpal12.futurama.quotes.controllers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@RunWith(SpringJUnit4ClassRunner.class)
public class VersionControllerTest {

    private static final String VERSION = "SomeVersion";
    @InjectMocks
    private VersionController versionController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(versionController).build();
    }

    @Test
    public void getAppVersion_StoresAndReturnsVersion() throws Exception {
        Whitebox.setInternalState(versionController, "VERSION", VERSION);
        final String content = mockMvc.perform(get("/version"))
                .andReturn().getResponse().getContentAsString();

        assertEquals(VERSION, content);
    }

}
